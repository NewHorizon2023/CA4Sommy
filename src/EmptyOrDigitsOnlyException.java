public class EmptyOrDigitsOnlyException extends RuntimeException {
    public EmptyOrDigitsOnlyException(String fieldName) {
        super(fieldName + " cannot be empty. It cannot have only digits! Please correct this.");
    }

    public static void main(String[] args) throws Exception {
        Album[] albums = ReadData.readAllData();
        Album[] arr = AddNewAlbumRecord.addNewAlbumRecord(albums, "", 2, 0.11f, 1.11f, 2.11f);
        System.out.println(arr.length);
    }
}
