package net.spotapps.tester.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_images")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "imageId",
    "image"
})
public class UserImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("imageId")
    @Column(name = "image_id")
    private Long imageId;

    @JsonProperty("image")
    @Column
    private String image;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserProfile userProfile;

    public UserImage() {
    }

    public UserImage(Long imageId, String image) {
        this.imageId = imageId;
        this.image = image;
    }

    public UserImage(String image, UserProfile userProfile) {
        this.image = image;
        this.userProfile = userProfile;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((imageId == null) ? 0 : imageId.hashCode());
        result = prime * result + ((image == null) ? 0 : image.hashCode());
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
        UserImage other = (UserImage) obj;
        if (imageId == null) {
            if (other.imageId != null)
                return false;
        } else if (!imageId.equals(other.imageId))
            return false;
        if (image == null) {
            if (other.image != null)
                return false;
        } else if (!image.equals(other.image))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UserImage [imageId=" + imageId + ", image=" + image + "]";
    }


    
}
