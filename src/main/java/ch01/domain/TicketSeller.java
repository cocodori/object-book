package ch01.domain;

/**
 * 판매원은 매표소에서 초대장을 티켓으로 교환해주거나 판매하는 역할을 수행한다.
 * 판매원은 자신이 일하는 매표소(ch01.domain.TicketOffice)를 알아야 한다
 */
public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public TicketOffice getTicketOffice() {
        return this.ticketOffice;
    }
}
