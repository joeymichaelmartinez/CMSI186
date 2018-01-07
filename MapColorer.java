import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.HashSet;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
    
public class MapColorer {
    
    public static void colorMap() {
        Region[] mapRegions = Region.getAllRegionsAsArray();
        colorFrom(mapRegions, 0);
        outputColoring(mapRegions);
    }

    private static boolean colorFrom(Region[] regions, int index) {
        for(int i = 0; i <= 3; i++) {
            if(regions[index].canColorWith(i)) {
                regions[index].setColor(i);
                if(index == regions.length-1 || colorFrom(regions, index+1)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private static void outputColoring(Region[] mapRegions) {
        if (colorFrom(mapRegions, 0)){ 
            for(Region region : mapRegions){
                System.out.println(region.getName() + ":" + region.getColor());
                for (Region neighborRegion : region.getNeighbors()) {
                    System.out.println(region + "," + neighborRegion);
                }
            }
        }
        
        else {
            System.out.println("IMPOSSIBLE MAP");
        }
    }
    

    
    public void readMapFromStandardInput() {
        new BufferedReader(new InputStreamReader(System.in))
            .lines()
            .forEach(line -> {
                String[] pair = line.trim().split(",");
                Region region0 = Region.forName(pair[0]);
                Region region1 = Region.forName(pair[1]);
                region0.addNeighbor(region1);
            });
    }

    private static void printMap() {
        System.out.println("The countries are: ");
        
        Arrays.stream(Region.getAllRegionsAsArray()).forEach(System.out::println);
        
        for (Region r : Region.getAllRegionsAsArray()) {
            System.out.println(r + " with Neighbors" + r.getNeighbors());
        } 
        
    }
    
    
    public static void main(String[] args) {
        MapColorer mapColorer = new MapColorer();
        mapColorer.readMapFromStandardInput();
        mapColorer.colorMap();
    }
}

class Region {

    private static Map<String, Region> allRegions = new TreeMap<>();

    public static Region forName(String name) {
        allRegions.putIfAbsent(name, new Region(name));
        return allRegions.get(name);
    }

    public static Region[] getAllRegionsAsArray() {
        return allRegions.values().toArray(new Region[allRegions.size()]);
    }

    private String name;
    private Integer color;
    private Set<Region> neighbors = new HashSet<>();

    private Region(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getColor() {
        return color;
    }

    public boolean canColorWith(int color) {
        return !neighbors.stream().anyMatch(n -> Objects.equals(n.color,color));
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void removeColor() {
        this.color = null;
    }

    public Set<Region> getNeighbors() {
        return neighbors;
    }
   
    public String toString() {
        return this.name;
    }

    public void addNeighbor(Region region) {
        Objects.requireNonNull(region);
        neighbors.add(region);
        region.neighbors.add(this);
    }
}