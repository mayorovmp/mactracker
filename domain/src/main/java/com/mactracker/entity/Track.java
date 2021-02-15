package com.mactracker.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "track")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id")
    protected Long id;

    @Column(name = "user_id", insertable = false, updatable = false)
    protected Long userId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    protected User user;

    @OneToMany(mappedBy = "track")
    protected Set<TrackStatus> statuses;

    @Column(name = "code")
    protected String code;

    @Column(name = "full_name")
    protected String fullName;

    @Column(name = "phone")
    protected String phone;

    @Column(name = "comment")
    protected String comment;
}
