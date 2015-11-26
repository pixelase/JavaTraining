package com.github.pixelase.dataaccess.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.github.pixelase.dataaccess.dao.AddressDao;
import com.github.pixelase.dataaccess.model.Address;
import com.nurkiewicz.jdbcrepository.JdbcRepository;
import com.nurkiewicz.jdbcrepository.RowUnmapper;

@Repository
public class AddressDaoImpl extends JdbcRepository<Address, Integer> implements AddressDao {
	private static final String tableName = "address";

	public AddressDaoImpl() {
		super(rowMapper, rowUnmapper, tableName);
	}

	public static final RowMapper<Address> rowMapper = new RowMapper<Address>() {
		@Override
		public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Address(rs.getInt("id"), rs.getString("street"), rs.getString("house"),
					rs.getString("apartment"));
		}
	};

	private static final RowUnmapper<Address> rowUnmapper = new RowUnmapper<Address>() {
		@Override
		public Map<String, Object> mapColumns(Address address) {
			Map<String, Object> mapping = new LinkedHashMap<String, Object>();
			mapping.put("id", address.getId());
			mapping.put("street", address.getStreet());
			mapping.put("house", address.getHouse());
			mapping.put("apartment", address.getApartment());
			return mapping;
		}
	};

	@Override
	protected <S extends Address> S postCreate(S entity, Number generatedId) {
		entity.setId(generatedId.intValue());
		return entity;
	}
}