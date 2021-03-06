package ex;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FII_Sample {

    public List<Bauble> getFreeBees(List<Bauble> baubles) {

        return baubles.stream().filter(b -> b.isFree()).collect(Collectors.toList());
    }

    public List<String> getNames(List<Bauble> baubles) {

        return baubles.stream().map(b -> b.getName()).collect(Collectors.toList());
    }

    public List<Bauble> getfpFreeBees(List<Bauble> baubles) {

        return baubles.stream().filter(Bauble::isFree).collect(Collectors.toList());
    }

    public List<String> fpGetNames(List<Bauble> baubles) {

        return baubles.stream().map(Bauble::getName).collect(Collectors.toList());
    }

    public Map<String, Long> fpBuildMapper(List<Long> l) {

        return l.stream().collect(Collectors.toMap(Object::toString, e -> e));
    }

    public boolean containsOnACollect(List<Bauble> baubles, String name) {
        return baubles.stream().map(Bauble::getName).collect(Collectors.toSet()).contains(name);
    }

    public boolean poorMansAnyMatch(List<Bauble> baubles, String name) {
        return baubles.stream().map(Bauble::getName).filter(n -> n.equals(name)).findFirst().isPresent();
    }

    public Bauble get0OnCollect(List<Bauble> baubles) {
        return baubles.stream().collect(Collectors.toList()).get(0);
    }

    public List<Bauble> backToBackFilter(Set<Bauble> baubles) {
        return baubles.stream().filter(b -> b.getName().equals("diamonds")).filter(b -> b.isFree()).collect(Collectors.toList());
    }

    public Map<String, Bauble> mapIdentity(List<Bauble> baubles) {
        return baubles.stream().collect(Collectors.toMap(Bauble::getName, b -> b));
    }

    public int sizeOnACollect(List<Bauble> baubles, String name) {
        return baubles.stream().filter(b -> b.getName().equals(name)).collect(Collectors.toSet()).size();
    }

    public static class Bauble {

        public String getName() {
            return "golden orb";
        }

        public boolean isFree() {
            return true;
        }
    }

    public enum GiantSpeak {
        FEE, FI, FO, FUM, BLUB;

        static Set<GiantSpeak> sayings = EnumSet.allOf(GiantSpeak.class);
        static {
            sayings.removeIf(s -> !s.whatGiantSay());
        }

        public boolean whatGiantSay() {
            return this != GiantSpeak.BLUB;
        }
    }
}
