package com.finance.helper.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "alarm")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alarm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private float minval;

    private float maxval;

    @OneToOne
    @JoinColumn(name = "attribute_id", referencedColumnName = "id")
    private Attribute attribute;

    @OneToOne
    @JoinColumn(name = "user_product_id", referencedColumnName = "id")
    private UserProduct userProduct;
}
