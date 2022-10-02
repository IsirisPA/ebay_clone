package com.isiris.ebayclone.repository.entities.auction;

import com.isiris.ebayclone.model.auction.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class AuctionEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String sellerId;
    private String name;
    private Category category;
    private Double currently;
    private Double buyPrice;
    private Double firstBid;
    private Integer numberOfBids;
    @OneToMany(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private List<BidEntity> bids;
    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private LocationEntity location;
    private String country;
    private LocalDateTime started;
    private LocalDateTime ends;
    private String description;
}
