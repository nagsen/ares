package org.ares.security.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.ares.security.common.neo4j.entity.BaseRelationship;
import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.StartNode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GroupRoleRel extends BaseRelationship {
	@StartNode
	private Group group;
	@EndNode
	private Role role;

}
