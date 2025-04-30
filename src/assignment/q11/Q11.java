package assignment.q11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q11
{
    public static void main(String[] args) {
        Map<String, Set<Asset>> departmentAssets = new HashMap<>();
        Set<String> globalAssetIds = new HashSet<>();

        // Add assets
        addAsset(departmentAssets, globalAssetIds, "IT", new Asset("A101", "Laptop"));
        addAsset(departmentAssets, globalAssetIds, "HR", new Asset("A102", "Printer"));
        addAsset(departmentAssets, globalAssetIds, "Finance", new Asset("A103", "Projector"));
        addAsset(departmentAssets, globalAssetIds, "IT", new Asset("A102", "Tablet")); // Duplicate

        // Print department assets
        for (Map.Entry<String, Set<Asset>> entry : departmentAssets.entrySet()) {
            System.out.println("Department: " + entry.getKey());
            entry.getValue().forEach(System.out::println);
        }
    }

    private static void addAsset(Map<String, Set<Asset>> map, Set<String> globalIds,
                                 String department, Asset asset) {
        if (globalIds.contains(asset.getId())) {
            System.out.println("Duplicate asset ID detected: " + asset.getId() +
                    " (Department: " + department + ")");
            return;
        }

        map.computeIfAbsent(department, d -> new HashSet<>()).add(asset);
        globalIds.add(asset.getId());
    }
}
