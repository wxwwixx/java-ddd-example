package tv.codely.mooc.courses.application.create;

import tv.codely.mooc.courses.domain.*;
import tv.codely.shared.domain.bus.event.EventBus;

@Service
public final class CourseCreator {
    private final CourseRepository repository;
    private final EventBus eventBus;

    public void create(String id, String name, String duration) {
        validate(name, duration);

        System.out.println("[CourseCreator] Creating course:");
        System.out.println(" - ID: " + id);
        System.out.println(" - Name: " + name);
        System.out.println(" - Duration: " + duration);

        Course course = new Course(
            new CourseId(id),
            new CourseName(name),
            new CourseDuration(duration)
        );

        repository.save(course);
        eventBus.publish(course.pullDomainEvents());

        System.out.println("[CourseCreator] Course created and events published successfully.");
    }

    private void validate(String name, String duration) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Course name cannot be empty.");
        }

        if (duration == null || duration.isBlank()) {
            throw new IllegalArgumentException("Course duration cannot be empty.");
        }
    }
}
