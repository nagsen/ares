package org.ares.security.common.neo4j.entity;

import java.util.Date;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import lombok.Data;

@Data
@NodeEntity
public class BaseEntity {
	@GraphId
	private Long id;
	private Date createdDate;
	private String createdBy;
	private Date lastUpdatedDate;
	private String lastUpdatedBy;
}
