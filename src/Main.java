public class Main {
    public static void main(String[] args) {
        // AutoSaveThread 인스턴스 생성
        AutoSaveThread autoSaveThread = new AutoSaveThread();
        // 이 스레드를 데몬 스레드로 설정 (메인 스레드 종료 시 함께 종료)
        autoSaveThread.setDaemon(true);
        // AutoSaveThread 스레드 시작
        autoSaveThread.start();

        try {
            // 메인 스레드를 3.1초 동안 일시 중지
            Thread.sleep(3100);
        } catch (InterruptedException e) {
        }

        // 메인 스레드 종료 메시지 출력
        System.out.println("메인 스레드 종료");
    }
}

class AutoSaveThread extends Thread {

    // "자동 저장"을 수행하는 메서드
    public void save() {
        System.out.println("자동 저장");
    }

    @Override
    public void run() {
        // 무한 루프: 스레드 실행
        while (true) {
            try {
                // 1초 동안 스레드를 일시 중지
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            // "자동 저장" 메서드 호출
            save();
        }
    }
}
