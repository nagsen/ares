package org.ares.security.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.ares.security.common.neo4j.entity.BaseRelationship;
import org.ares.security.common.neo4j.type.RelationshipType;
import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@Data
@EqualsAndHashCode(callSuper=true)
@RelationshipEntity(type=RelationshipType.MEMBER_OF)
public class UserGroupRel extends BaseRelationship{
	@StartNode
	private User user;
	@EndNode
	private Group group;
}
