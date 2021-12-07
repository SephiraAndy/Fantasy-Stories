package sephiraandy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    void shouldConductBehaviour() {
        final var testApplicationBehaviour = new TestApplicationBehaviour();
        final var application = new Application(testApplicationBehaviour);

        application.run();

        assertEquals("start update update update end ", testApplicationBehaviour.log);
    }

    @Test
    void shouldEndIfExceptionCaught() {
        final var testApplicationBehaviour = new TestExceptionBehaviour();
        final var application = new Application(testApplicationBehaviour);

        application.run();

        assertEquals("start end ", testApplicationBehaviour.log);
    }

    private static class TestApplicationBehaviour implements Behaviour<Application> {
        int updateCount = 0;
        String log = "";
        @Override
        public void start(Application application) {
            log += "start ";
        }

        @Override
        public void conduct(Application application) {
            log += "update ";
            ++updateCount;
            if (updateCount == 3) {
                application.stop();
            }
        }

        @Override
        public void end(Application application) {
            log += "end ";
        }
    }

    private static class TestExceptionBehaviour implements Behaviour<Application> {
        String log = "";
        @Override
        public void start(Application application) {
            log += "start ";
        }

        @Override
        public void conduct(Application application) {
            throw new RuntimeException("Exception to break flow");
        }

        @Override
        public void end(Application application) {
            log += "end ";
        }
    }
}