package designpatterns.state.gumball;

public class GumballMachine {
    private final static int SOLD_OUT = 0;
    private final static int NO_QUARTER = 1;
    private final static int HAS_QUARTER = 2;
    private final static int SOLD = 3;

    int state = SOLD_OUT;
    int count = 0;

    public GumballMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = NO_QUARTER;
        }
    }

    public void insertQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("동전은 한 개만 넣어주세요.");
        } else if (state == NO_QUARTER) {
            state = HAS_QUARTER;
            System.out.println("동전을 넣으셨습니다.");
        } else if (state == SOLD_OUT) {
            System.out.println("매진되었습니다. 다음 기회에 이용해주세요.");
        } else if (state == SOLD) {
            System.out.println("잠깐만 기다려 주세요. 알맹이가 나가고 있습니다.");
        }
    }

    public void ejectQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("동전이 반환됩니다.");
            state = NO_QUARTER;
        } else if (state == NO_QUARTER) {
            System.out.println("동전을 넣어주세요.");
        } else if (state == SOLD) {
            System.out.println("이미 알맹이를 봅으셨습니다.");
        } else if (state == SOLD_OUT) {
            System.out.println("동전을 넣지 않으셨습니다. 동전이 반환되지 않습니다.");
        }
    }

    public void turnCrank() {
        if (state == SOLD) {
            System.out.println("손잡이는 한 번만 돌려주세요.");
        } else if (state == NO_QUARTER) {
            System.out.println("동전을 넣어주세요.");
        } else if (state == SOLD_OUT) {
            System.out.println("매진되었습니다.");
        } else if (state == HAS_QUARTER) {
            System.out.println("손잡이를 돌리셨습니다.");
            state = SOLD;
            dispense();
        }
    }

    private void dispense() {
        if (state == SOLD) {
            System.out.println("알맹이가 나가고 있습니다.");
            count = count - 1;
            if (count == 0) {
                System.out.println("더 이상 알맹이가 없습니다.");
                state = SOLD_OUT;
            } else {
                state = NO_QUARTER;
            }
        } else if (state == NO_QUARTER) {
            System.out.println("동전을 넣어주세요.");
        } else if (state == SOLD_OUT) {
            System.out.println("매진입니다.");
        } else if (state == HAS_QUARTER) {
            System.out.println("알맹이가 나갈 수 없습니다.");
        }
    }

    public void refill(int numGumBalls) {
        this.count = numGumBalls;
        state = NO_QUARTER;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\n주식회사 왕뽑기");
        result.append("\n자바로 돌아가는 2004년형 뽑기 기계(지금은 2021년..)\n");
        result.append("남은 개수: ");
        result.append(count);
        result.append("개");
        
        if (state == SOLD_OUT) {
            result.append("매진");
        } else if (state == NO_QUARTER) {
            result.append("동전 투입 대기중");
        } else if (state == HAS_QUARTER) {
            result.append("손잡이 돌리기 대기중");
        } else if (state == SOLD) {
            result.append("뽑기 나오는중");
        }

        result.append("\n");
        return result.toString();
    }
}
