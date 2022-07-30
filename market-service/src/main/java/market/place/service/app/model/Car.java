package market.place.service.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "index")
    private long id;

    @Column(name = "model")
    private String model;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
}
