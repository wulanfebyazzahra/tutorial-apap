package apap.tutorial.traveloke.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="review")
public class ReviewModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=10)
    @Column(name="namaReviewer", nullable = false)
    private String namaReviewer;

    @NotNull
    @Size(max=50)
    @Column(name="isiReview", nullable = false)
    private String isiReview;

    @NotNull
    @Size(max=50)
    @Column(name="saran", nullable = true)
    private String saran;

    @ManyToOne(fetch= FetchType.EAGER, optional = false)
    @JoinColumn(name= "kamarID", referencedColumnName = "noKamar", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private KamarModel kamar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaReviewer() {
        return namaReviewer;
    }

    public void setNamaReviewer(String namaReviewer) {
        this.namaReviewer = namaReviewer;
    }

    public String getIsiReview() {
        return isiReview;
    }

    public void setIsiReview(String isiReview) {
        this.isiReview = isiReview;
    }

    public String getSaran() {
        return saran;
    }

    public void setSaran(String saran) {
        this.saran = saran;
    }

    public List<KamarModel> getListKamar() {
        return listKamar;
    }

    public void setListKamar(List<KamarModel> listKamar) {
        this.listKamar = listKamar;
    }
}