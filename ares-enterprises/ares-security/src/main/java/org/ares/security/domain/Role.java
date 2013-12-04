package org.ares.security.domain;

import java.util.Set;

import org.ares.security.common.neo4j.entity.BaseEntity;
import org.ares.security.common.neo4j.index.IndexName;
import org.ares.security.common.neo4j.type.RelationshipType;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.support.index.IndexType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@RelationshipEntity
public class Role extends BaseEntity {

	@Indexed(unique = true, indexType = IndexType.FULLTEXT, indexName = IndexName.ROLE_NAME)
	private String name;
	private String desc;
	@RelatedTo(elementClass = User.class, direction = Direction.INCOMING, type = RelationshipType.HAS_ROLE)
	private Set<User> users;
	@RelatedTo(elementClass = Group.class, direction = Direction.INCOMING, type = RelationshipType.HAS_ROLE)
	private Set<Group> groups;
	@RelatedTo(elementClass=Permission.class,direction=Direction.OUTGOING,type=RelationshipType.HAS_PERMISSION)
	private Set<Permission> permissions;
}
