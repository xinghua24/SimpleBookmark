package com.xinghua24.authservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
	generator = ObjectIdGenerators.PropertyGenerator.class,
	property = "username"
)
public class User {
	@Id
	private String username;
	
	private String password;
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		User rhs = (User) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(obj))
				.append(username, rhs.username)
				.append(password, rhs.password)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(username).append(password).toHashCode();
	}
}