package com.domain.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
// import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// import lombok.Data;
// import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tbl_categories")
@SQLDelete(sql = "UPDATE tbl_categories SET deleted = true WHERE id=?")
// @Where(clause = "deleted = false")
@FilterDef(name = "deletedCategoryFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedCategoryFilter", condition = "deleted = :isDeleted")
@Getter
@Setter
@NoArgsConstructor
public class Category extends BaseEntity<String> implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String name;

    private boolean deleted = Boolean.FALSE; //false = not deleted, TRUE= deleted

    

    
}
