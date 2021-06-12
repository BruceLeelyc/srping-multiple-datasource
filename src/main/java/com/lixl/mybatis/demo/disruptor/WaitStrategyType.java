package net.nicetuan.weapp.data.disruptor.strategy;

import com.lmax.disruptor.*;

import java.util.concurrent.TimeUnit;

/**
 * @author hanxiaowei
 */
public enum WaitStrategyType {

    /**
     * @see BlockingWaitStrategy
     */
    BLOCKING {
        public WaitStrategy instance() {
            return new BlockingWaitStrategy();
        }
    },

    /**
     * @see BusySpinWaitStrategy
     */
    BUSY_SPIN {
        public WaitStrategy instance() {
            return new BusySpinWaitStrategy();
        }
    },

    /**
     * @see LiteBlockingWaitStrategy
     */
    LITE_BLOCKING {
        public WaitStrategy instance() {
            return new LiteBlockingWaitStrategy();
        }
    },

    /**
     * @see SleepingWaitStrategy
     */
    SLEEPING_WAIT {
        public WaitStrategy instance() {
            return new SleepingWaitStrategy();
        }
    },

    /**
     * @see YieldingWaitStrategy
     */
    YIELDING {
        public WaitStrategy instance() {
            return new YieldingWaitStrategy();
        }
    },

    TIMEOUT_BLOCKING_WAIT {
        public WaitStrategy instance() {
            return new TimeoutBlockingWaitStrategy(3000, TimeUnit.MILLISECONDS);
        }
    },

    LITE_TIMEOUT_BLOCKING_WAIT {
        public WaitStrategy instance() {
            return new LiteTimeoutBlockingWaitStrategy(3000, TimeUnit.MILLISECONDS);
        }
    },
    PHASED_BACK_OFF_WAIT {
        public WaitStrategy instance() {
            return PhasedBackoffWaitStrategy.withLiteLock(1500, 3000, TimeUnit.NANOSECONDS);
        }
    };

    public abstract WaitStrategy instance();
}
