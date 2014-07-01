package com.ncr.ATMMonitoring.pojo;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.log4j.Logger;

/**
 * The TerminalModel Pojo.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "terminal_models")
public class TerminalModel {

    /** The logger. */
    static private Logger logger = Logger.getLogger(TerminalModel.class
	    .getName());

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "terminal_models_id_seq")
    @SequenceGenerator(name = "terminal_models_id_seq", sequenceName = "terminal_models_id_seq", allocationSize = 1)
    private Integer id;

    /** The model. */
    @Column(name = "model", length = 50)
    private String model;

    /** The product class. */
    @Column(name = "product_class", length = 50, unique = true)
    private String productClass;

    /** The nickname. */
    @Column(name = "nickname", length = 50)
    private String nickname;

    /** The manufacturer. */
    @Column(name = "manufacturer", length = 50)
    private String manufacturer;

    /** The height. */
    @Column(name = "height")
    private Integer height;

    /** The width. */
    @Column(name = "width")
    private Integer width;

    /** The depth. */
    @Column(name = "depth")
    private Integer depth;

    /** The max weight. */
    @Column(name = "max_weight")
    private Double maxWeight;

    /** The min weight. */
    @Column(name = "min_weight")
    private Double minWeight;

    /** The photo. */
    @Column(name = "photo")
    private byte[] photo;

    // We don't need this for now
    // @OneToMany(mappedBy = "terminalModel")
    // @Cascade(CascadeType.ALL)
    // private Set<Terminal> terminals;
    //
    // public Set<Terminal> getTerminals() {
    // return terminals;
    // }
    //
    // public void setTerminals(Set<Terminal> terminals) {
    // this.terminals = terminals;
    // }

    /**
     * Gets the id.
     * 
     * @return the id
     */
    public Integer getId() {
	return id;
    }

    /**
     * Sets the id.
     * 
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
	this.id = id;
    }

    /**
     * Gets the model.
     * 
     * @return the model
     */
    public String getModel() {
	return model;
    }

    /**
     * Sets the model.
     * 
     * @param model
     *            the new model
     */
    public void setModel(String model) {
	this.model = model;
    }

    /**
     * Gets the manufacturer.
     * 
     * @return the manufacturer
     */
    public String getManufacturer() {
	return manufacturer;
    }

    /**
     * Sets the manufacturer.
     * 
     * @param manufacturer
     *            the new manufacturer
     */
    public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
    }

    /**
     * Gets the photo.
     * 
     * @return the photo
     */
    public byte[] getPhoto() {
	return photo;
    }

    /**
     * Sets the photo.
     * 
     * @param photo
     *            the new photo
     */
    public void setPhoto(byte[] photo) {
	this.photo = photo;
    }

    /**
     * Gets the photo as image.
     * 
     * @param width
     *            the width
     * @param height
     *            the height
     * @return the photo as image
     */
    public BufferedImage getPhotoAsImage(int width, int height) {
	ByteArrayInputStream in = new ByteArrayInputStream(photo);
	BufferedImage img;
	try {
	    img = ImageIO.read(in);
	} catch (IOException e) {
	    logger.error("Error while retrieving image from Terminal Model with id "
		    + id);
	    return null;
	}
	// If we have width and height, resize the image
	if ((height == 0) && (width != 0)) {
	    height = (width * img.getHeight()) / img.getWidth();
	} else {
	    if ((width == 0) && (height != 0)) {
		width = (height * img.getWidth()) / img.getHeight();
	    }
	}
	if ((width != 0) && (height != 0)) {
	    Image scaledImage = img.getScaledInstance(width, height,
		    Image.SCALE_SMOOTH);
	    img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	    img.getGraphics().drawImage(scaledImage, 0, 0, new Color(0, 0, 0),
		    null);
	}
	return img;
    }

    /**
     * Gets the nickname.
     * 
     * @return the nickname
     */
    public String getNickname() {
	return nickname;
    }

    /**
     * Sets the nickname.
     * 
     * @param nickname
     *            the new nickname
     */
    public void setNickname(String nickname) {
	this.nickname = nickname;
    }

    /**
     * Gets the height.
     * 
     * @return the height
     */
    public Integer getHeight() {
	return height;
    }

    /**
     * Sets the height.
     * 
     * @param height
     *            the new height
     */
    public void setHeight(Integer height) {
	this.height = height;
    }

    /**
     * Gets the width.
     * 
     * @return the width
     */
    public Integer getWidth() {
	return width;
    }

    /**
     * Sets the width.
     * 
     * @param width
     *            the new width
     */
    public void setWidth(Integer width) {
	this.width = width;
    }

    /**
     * Gets the depth.
     * 
     * @return the depth
     */
    public Integer getDepth() {
	return depth;
    }

    /**
     * Sets the depth.
     * 
     * @param depth
     *            the new depth
     */
    public void setDepth(Integer depth) {
	this.depth = depth;
    }

    /**
     * Gets the max weight.
     * 
     * @return the max weight
     */
    public Double getMaxWeight() {
	return maxWeight;
    }

    /**
     * Sets the max weight.
     * 
     * @param maxWeight
     *            the new max weight
     */
    public void setMaxWeight(Double maxWeight) {
	this.maxWeight = maxWeight;
    }

    /**
     * Gets the min weight.
     * 
     * @return the min weight
     */
    public Double getMinWeight() {
	return minWeight;
    }

    /**
     * Sets the min weight.
     * 
     * @param minWeight
     *            the new min weight
     */
    public void setMinWeight(Double minWeight) {
	this.minWeight = minWeight;
    }

    /**
     * Gets the product class.
     * 
     * @return the product class
     */
    public String getProductClass() {
	return productClass;
    }

    /**
     * Sets the product class.
     * 
     * @param productClass
     *            the new product class
     */
    public void setProductClass(String productClass) {
	this.productClass = productClass;
    }
}