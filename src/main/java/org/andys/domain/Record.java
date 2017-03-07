package org.andys.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Record {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "value", nullable = false)
    private Long value;
    
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)  
    private Date date;
    

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Record other = (Record) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Record [id=" + id + ", value=" + value + ", date=" + date + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
    


}
