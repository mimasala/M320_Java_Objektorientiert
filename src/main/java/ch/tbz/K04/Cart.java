package ch.tbz.K04;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor
public class Cart {
    private Coupons coupons;
    public Cart(){
        this.coupons = new Coupons();
    }
}
