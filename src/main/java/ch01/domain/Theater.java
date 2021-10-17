package ch01.domain;

/**
 * 소극장을 구현하는 클래스.
 * 이 클래스는 관람객(ch01.domain.Audience)를 맞이할 수 있도록 enter 메서드를 구현한다
 */
public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        ticketSeller.sellTo(audience);
    }
}
