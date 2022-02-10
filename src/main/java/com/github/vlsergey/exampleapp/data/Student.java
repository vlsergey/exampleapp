package com.github.vlsergey.exampleapp.data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Nonnull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.github.vlsergey.exampleapp.data.utils.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
@Setter
@ToString
@Table(name = "students")
public class Student extends BaseEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID studentId;

    @Column(nullable = true)
    @Nonnull
    @NonNull
	private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @ToString.Exclude
    @Nonnull
    @NonNull
    private Set<Group> groups = new HashSet<>();

}
