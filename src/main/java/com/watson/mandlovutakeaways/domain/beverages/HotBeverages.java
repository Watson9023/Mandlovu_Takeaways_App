package com.watson.mandlovutakeaways.domain.beverages;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Long on 8/14/2017.
 */
@Entity
public class HotBeverages implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long _id;
    private String name;
    private String price;

    public HotBeverages() {
    }

    public HotBeverages(Builder builder) {
        this._id = builder._id;
        this.name = builder.name;
        this.price = builder.price;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        return (int) (_id ^ (_id >>> 32));
    }

    public static class Builder
    {
        private long _id;
        private String name;
        private String price;

        public Builder id(long value)
        {
            this._id=value;
            return this;
        }

        public Builder name(String value)
        {
            this.name = value;
            return this;
        }

        public Builder price(String value)
        {
            this.price = value;
            return this;
        }

        public Builder copy(HotBeverages value)
        {
            this._id = value._id;
            this.name = value.name;
            this.price = value.price;
            return this;
        }

        public HotBeverages build()
        {
            return new HotBeverages(this);
        }
    }
}
