package org.ares.security.domain;

import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.ares.security.common.neo4j.entity.BaseEntity;
import org.ares.security.common.neo4j.index.IndexName;
import org.ares.security.common.neo4j.type.RelationshipType;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.support.index.IndexType;

@Data
@EqualsAndHashCode(callSuper = true)
@NodeEntity
public class User extends BaseEntity {
	@Indexed(unique = true)
	private Integer userId;
	private String password;
	@Indexed(indexType = IndexType.FULLTEXT, indexName = IndexName.USER_FIRST_NAME)
	private String firstName;
	private String middleName;
	@Indexed(indexType = IndexType.FULLTEXT, indexName = IndexName.USER_LAST_NAME)
	private String lastName;
	private String email;
	private String country;
	private String state;
	private String city;
	private String postalCode;
	private String currentLocation;
	@RelatedTo(elementClass = Group.class, direction = Direction.OUTGOING, type = RelationshipType.MEMBER_OF)
	private Set<Group> groups;
	@Fetch
	@RelatedTo(elementClass = Role.class, direction = Direction.OUTGOING, type = RelationshipType.HAS_ROLE)
	private Set<Role> roles;
	@Fetch
	@RelatedTo(elementClass = Permission.class, direction = Direction.OUTGOING, type = RelationshipType.HAS_PERMISSION)
	private Set<Permission> permissions;
}
