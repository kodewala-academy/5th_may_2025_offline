Constructor Injection: Best for mandatory dependencies, ensures immutability.

Setter Injection: Good for optional dependencies, can be modified later.

Field Injection: Quick & simple, but harder to test.

All dependencies are Java-based configuration, no XML required.

@Autowired works with setter and field, constructor injection can also use @Autowired (optional in modern Spring).