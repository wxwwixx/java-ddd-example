package tv.codely.analytics.domain_events.domain;

import java.time.Instant;

public final class AnalyticsDomainEvent {
    private final AnalyticsDomainEventId          id;
    private final AnalyticsDomainEventAggregateId aggregateId;
    private final AnalyticsDomainEventName        name;
    private final AnalyticsDomainEventBody        body;
    private final Instant                          occurredOn;

    public AnalyticsDomainEvent(
        AnalyticsDomainEventId id,
        AnalyticsDomainEventAggregateId aggregateId,
        AnalyticsDomainEventName name,
        AnalyticsDomainEventBody body,
        Instant occurredOn
    ) {
        this.id          = id;
        this.aggregateId = aggregateId;
        this.name        = name;
        this.body        = body;
        this.occurredOn  = occurredOn;
    }

    public AnalyticsDomainEventId getId() {
        return id;
    }

    public AnalyticsDomainEventAggregateId getAggregateId() {
        return aggregateId;
    }

    public AnalyticsDomainEventName getName() {
        return name;
    }

    public AnalyticsDomainEventBody getBody() {
        return body;
    }

    public Instant getOccurredOn() {
        return occurredOn;
    }

    @Override
    public String toString() {
        return "AnalyticsDomainEvent{" +
            "id=" + id +
            ", aggregateId=" + aggregateId +
            ", name=" + name +
            ", body=" + body +
            ", occurredOn=" + occurredOn +
            '}';
    }
}
