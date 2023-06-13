package game.model.entities.actions;



public abstract class Action {
    private int cooldown;
    private long lasttime;

    public Action(){
        cooldown = 1500;
        lasttime = 0;
    }

    public Action(int cooldown){
        this.cooldown = cooldown;
        lasttime = 0;
    }


    public int getCooldown() {
        return cooldown;
    }

    public float getCooldownPercent() {
        float percent = (System.currentTimeMillis() - lasttime) /(float) cooldown;
        if (percent > 1){
            return 1.0f;
        }
        return percent;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public long getLasttime() {
        return lasttime;
    }

    public void setLasttime(long lasttime) {
        this.lasttime = lasttime;
    }

}
