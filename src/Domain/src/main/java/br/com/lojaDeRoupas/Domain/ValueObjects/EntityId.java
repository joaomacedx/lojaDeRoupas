package br.com.lojaDeRoupas.Domain.ValueObjects;

import java.util.UUID;

public class EntityId {
  public UUID Value;
  public EntityId(UUID value) {
      this.Value = value;
  }
  public static EntityId MakeNew() {
    return new EntityId(UUID.randomUUID());
  }
  public static EntityId MakeFrom(UUID value)
  {
    Validate(value);
    return new EntityId(value);
  }
  private static void Validate(UUID value)
  {
      if (value == null)
      {
        throw new Error("EntityId n pode ser nulo");
      }
  }
}
