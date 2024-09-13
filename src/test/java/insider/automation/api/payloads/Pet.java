package insider.automation.api.payloads;


import java.util.List;

public class Pet {
    private long id;
    private String status;
    private String name;

    private List<String> photoUrls;

    private Category category;

    private List<Tags> tags;

    public Pet(long id, String status, String name, List<String> photoUrls, Category category, List<Tags> tags) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.photoUrls = photoUrls;
        this.category = category;
        this.tags = tags;
    }

    public Pet() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

}
