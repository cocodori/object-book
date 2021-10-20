package ch01.domain;

/**
 * 이벤트 당첨자는 티켓을 교환할 초대장을 있을 것.
 * 일반 관람객은 티켓을 살 돈을 가지고 있을 것.
 * 따라서 관람객이 가지고 올 수 있는 소지품은 초대장, 현금, 티켓 세 가지 뿐임.
 * 이때 관람객은 가방에 이것들을 보관한다고 가정.
 */
public class Bag {
    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    public Long hold(Ticket ticket) {
        if (hasInvitation()) {
            setTicket(ticket);
            return 0L;
        } else {
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

    private boolean hasInvitation() {
        return invitation != null;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }
}
