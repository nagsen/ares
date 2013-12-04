package org.ares.security.common.neo4j.entity;

import java.util.Date;

import lombok.Data;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;

@RelationshipEntity
@Data
public class BaseRelationship {
	@GraphId
	private Long id;
	private Date createdDate;
	private String createdBy;
}
