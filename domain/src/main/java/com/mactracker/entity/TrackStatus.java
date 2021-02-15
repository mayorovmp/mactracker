package com.mactracker.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "track_status")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TrackStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id")
    protected Long id;

    @Column(name = "track_id", insertable = false, updatable = false)
    protected Long trackId;

    @ManyToOne
    @JoinColumn(name = "track_id")
    protected Track track;

    @Column(name = "option_id", insertable = false, updatable = false)
    protected Long optionId;

    @ManyToOne
    @JoinColumn(name = "option_id")
    protected Option option;
}
