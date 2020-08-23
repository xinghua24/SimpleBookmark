package com.xinghua24.bookmarkbe.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="bookmarklist")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
	property = "id"
)
public class BookmarkList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "name")
    @NotBlank(message = "Name is mandatory")
    private String name;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    private User user;
    
    @OneToMany(
    	mappedBy = "bookmarklist",
    	cascade = CascadeType.ALL,
    	orphanRemoval = true
    )
    private List<Bookmark> bookmarks = new ArrayList<>();
    
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
		BookmarkList rhs = (BookmarkList) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(obj))
				.append(id, rhs.id)
				.append(name, rhs.name)
				.isEquals();
	}

    @Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(name).toHashCode();
	}
}
