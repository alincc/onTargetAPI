package com.ontarget.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sanjeevghimire on 10/9/15.
 */
@Data
@Entity
@Table(name = "document_response")
public class DocumentResponse {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "document_response_id", nullable = false)
    private long documentResponseId;
    @Column(name = "response",columnDefinition = "TEXT")
    private String response;
    @JoinColumn(name = "response_by", referencedColumnName = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User responseBy;
    @Basic(optional = false)
    @Column(name = "response_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date responseDate;
    @JoinColumn(name = "response_modified_by", referencedColumnName = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User responseModifiedBY;
    @JoinColumn(name = "document_id", referencedColumnName = "document_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Document document;
    @Column(name = "response_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date responseModifiedDate;
    @Column(name = "status",length=10)
    private String status;

}
