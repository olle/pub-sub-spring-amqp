Pub/Sub for Spring® AMQP
========================

**WIP: Driving the initial version from this README, please feel free to
       provide feedback through issues.**

A faster way to build safer and more resilient distributed services. Get help
using structured approach to event and data consumption. Ensure decoupling of
components. Be better prepared for system evolution. Create more scalable
solutions. Enhance your designs, by using Pub/Sub for Spring AMQP.

Publisher
----------

The fluid Pub/Sub API makes it easy for developers to build structured message
publishers bound to business- or data oriented events. There's no need for
infrastructure code or complex setups.

Publishing data is as easy as a _one-liner_!

```java
    PubBuilder.publishTo("author-added").withValue("William Gibson");
```

Subscribers
-----------

Subscribing can very easily be done, with a declarative API that requires no
setup or infrastructure code.

```java
    SubBuilder.subscribeTo("author-added", String.class)
        .onEach(author -> System.out.println("Author was added: " + author));
```

Complex types can be used in subscriptions, and consumable data can easily be
mapped to POJO or DTO types.

```java
    SubBuilder.subscribeTo("gate-opened", GateOpenedEvent.class)
        .onEach(gate -> System.out.println("Opened " + gate));
```

Happy hacking!

---

Spring is a trademark of Pivotal Software, Inc. in the U.S. and other countries.
