package org.firescape.server.event;

import org.firescape.server.model.Mob;
import org.firescape.server.model.Player;

public abstract class WalkToMobEvent extends DelayedEvent {

  private final int radius;
  protected Mob affectedMob;

  public WalkToMobEvent(Player owner, Mob affectedMob, int radius) {
    super(owner, 500);
    this.affectedMob = affectedMob;
    this.radius = radius;
    if (owner.withinRange(affectedMob, radius)) {
      arrived();
      this.running = false;
    }
  }

  public abstract void arrived();

  public final void run() {
    if (owner.withinRange(affectedMob, radius)) {
      arrived();
    } else if (owner.hasMoved()) {
      return; // We're still moving
    } else {
      failed();
    }
    this.running = false;
  }

  public void failed() {
  } // Not abstract as isn't required

  public Mob getAffectedMob() {
    return affectedMob;
  }

}