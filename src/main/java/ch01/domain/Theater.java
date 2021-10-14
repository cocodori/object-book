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

    /**
     * 소극장은 먼저 관람객 가방 안에 초대장이 들어있는지 확인한다.
     * 들어 있다면 이벤트에 당첨된 관객이므로 판매원에게서 받은 티켓을 관람객 가방 안에 넣어준다.
     * 만약 초대장이 없다면, 티켓을 판매해야 한다.
     * 이 경우 소극장은 관람객 가방에서 티켓 금액 만큼 돈을 차감한 후에 매표소 금액을 증가 시킨다.
     * 그 다음, 소극장은 관람객 가방에 티켓을 넣어줌으로써 입장 절차는 끝난다.
     */
    public void enter(Audience audience) {
        if (audience.getBag().hasInvitation()) {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
        } else {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
}
