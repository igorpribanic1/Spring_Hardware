package com.example.Hardware.repository;

import com.example.Hardware.domain.Hardware;
import com.example.Hardware.domain.HardwareType;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Primary
@Repository
@AllArgsConstructor
public class JdbcHardwareRepository implements HardwareRepository{

    private JdbcTemplate jdbcTemplate;

    public List<Hardware> getAllHardware() {
        return jdbcTemplate.query("SELECT * FROM HARDWARE", new HardwareMapper());
    }

    public List<Hardware> getHardwareByCode(String code){
        return jdbcTemplate.query("SELECT * FROM HARDWARE WHERE CODE = ?",
                new HardwareMapper(), code);
    }

    public Integer saveNewHardware(Hardware hardware){
        final String SQL =
                "SELECT ID FROM FINAL TABLE (INSERT INTO HARDWARE (name, code, price, hardwareTypeId, quantity) VALUES (?, ?, ?, ?, ?)) HARDWARE";
        Integer generatedId = jdbcTemplate.queryForObject(SQL, Integer.class, hardware.getName(), hardware.getCode(), hardware.getPrice(),
                hardware.getHardwareType().getId(), hardware.getQuantity());
        hardware.setId(generatedId);
        return generatedId;
    }

    public Optional<Hardware> updateHardware(Hardware hardwareToUpdate, Integer id){
        if(hardwareByIdExists(id)) {
            final String SQL =
                    "UPDATE HARDWARE SET name = ?, code = ?, price = ?, hardwareTypeId = ?, quantity = ? WHERE ID = ?";
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL);
                ps.setString(1, hardwareToUpdate.getName());
                ps.setString(2, hardwareToUpdate.getCode());
                ps.setBigDecimal(3, hardwareToUpdate.getPrice());
                ps.setInt(4, hardwareToUpdate.getHardwareType().getId());
                ps.setInt(5, hardwareToUpdate.getQuantity());
                ps.setInt(6, id);
                return ps;
            });
            hardwareToUpdate.setId(id);
            return Optional.of(hardwareToUpdate);
        }
        else {
            return Optional.empty();
        }
    }


    public boolean hardwareByIdExists(Integer id) {
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT (*) FROM HARDWARE WHERE ID = ?", Integer.class, id);
        return count > 0;
    }


    public boolean deleteHardwareById(Integer id) {
        if(hardwareByIdExists(id)) {
            jdbcTemplate.update(
                    "DELETE FROM HARDWARE WHERE ID = ?", id);
            return true;
        }
        else {
            return false;
        }
    }





    private static class HardwareMapper implements RowMapper<Hardware> {

        public Hardware mapRow(ResultSet rs, int i) throws SQLException {

            Hardware newHardware = new Hardware();
            newHardware.setId(rs.getInt("ID"));
            newHardware.setName(rs.getString("NAME"));
            newHardware.setCode(rs.getString("CODE"));
            newHardware.setPrice(rs.getBigDecimal("PRICE"));
            newHardware.setQuantity(rs.getInt("QUANTITY"));

            Integer hardwareTypeId = rs.getInt("HARDWARETYPEID");

            switch(hardwareTypeId){
                case 1:
                    newHardware.setHardwareType(HardwareType.CPU);
                    break;
                case 2:
                    newHardware.setHardwareType(HardwareType.GPU);
                    break;
                case 3:
                    newHardware.setHardwareType(HardwareType.MBO);
                    break;
                case 4:
                    newHardware.setHardwareType(HardwareType.RAM);
                    break;
                case 5:
                    newHardware.setHardwareType(HardwareType.STORAGE);
                    break;
                case 6:
                    newHardware.setHardwareType(HardwareType.OTHER);

            }

            return newHardware;
        }
    }


}
