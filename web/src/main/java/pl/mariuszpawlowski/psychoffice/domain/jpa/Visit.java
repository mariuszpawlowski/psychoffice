package pl.mariuszpawlowski.psychoffice.domain.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by mario on 19/05/16.
 */
@Entity
@Table(name = "visits")
public class Visit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "visit_date")
    private LocalDateTime date;

    @Column(name = "subject")
    private String subject;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private User user;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "visit")
    private Set<VisitFile> visitFiles;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<VisitFile> getVisitFiles() {
        return visitFiles;
    }

    public void setVisitFiles(Set<VisitFile> visitFiles) {
        this.visitFiles = visitFiles;
    }
}
