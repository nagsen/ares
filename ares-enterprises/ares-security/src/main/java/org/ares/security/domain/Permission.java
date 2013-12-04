package org.ares.security.domain;

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
public class Permission extends BaseEntity {
	@Indexed(unique = true, indexType = IndexType.FULLTEXT, indexName = IndexName.PERMISSION_NAME)
	private String name;
	@Indexed(unique = true)
	private String url;
	private String desc;
	@RelatedTo(elementClass = User.class, direction = Direction.INCOMING, type = RelationshipType.HAS_PERMISSION)
	private Set<User> users;
	@RelatedTo(elementClass = Group.class, direction = Direction.INCOMING, type = RelationshipType.HAS_PERMISSION)
	private Set<Group> groups;
	@RelatedTo(elementClass = Role.class, direction = Direction.INCOMING, type = RelationshipType.HAS_PERMISSION)
	private Set<Role> roles;
}
