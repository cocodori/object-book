package ch01.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 관람객이 소극장에 입장하기 위해 매표소에서 초대장을 티켓으로 교환하거나 구매해야 한다.
 * 따라서 매표소에는 판매할 티켓과 티켓의 판매 금액이 보관돼 있어야 한다.
 * 매표소는 판매하거나 교환해 줄 티켓 목록과 판매 금액을 인스턴스 변수로 포함한다.
 */
public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount, Ticket... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    public void sellTicket(Audience audience) {
        plusAmount(audience.buy(getTicket()));
    }

    private Ticket getTicket() {
        return tickets.remove(0);
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }
}
