package org.ares.security.domain;

import java.util.Date;
import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.ares.security.common.neo4j.entity.BaseEntity;
import org.ares.security.common.neo4j.index.IndexName;
import org.ares.security.common.neo4j.type.RelationshipType;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.support.index.IndexType;

@Data
@EqualsAndHashCode(callSuper = true)
@NodeEntity
public class Group extends BaseEntity {
	@Indexed(unique = true, indexType = IndexType.FULLTEXT, indexName = IndexName.GROUP_NAME)
	private String name;
	private String desc;
	private Date createdDate;
	private String createdBy;
	@RelatedTo(elementClass = User.class, direction = Direction.INCOMING, type = RelationshipType.MEMBER_OF)
	private Set<User> users;
	@RelatedTo(elementClass = Role.class, direction = Direction.OUTGOING, type = RelationshipType.HAS_ROLE)
	private Set<Role> roles;
	@RelatedTo(elementClass = Permission.class, direction = Direction.OUTGOING, type = RelationshipType.HAS_PERMISSION)
	private Set<Permission> permissions;
}
