package pastebintasks.model;

public class Paste {

  private String pasteCode;
  private String pasteExpiration;
  private String pasteName;
  private String syntaxHighlighting;

  public Paste(String pasteCode, String pasteExpiration, String pasteName) {
    this.pasteCode = pasteCode;
    this.pasteExpiration = pasteExpiration;
    this.pasteName = pasteName;
  }

  public Paste(String pasteCode, String pasteExpiration, String pasteName, String syntaxHighlighting) {
    this.pasteCode = pasteCode;
    this.pasteExpiration = pasteExpiration;
    this.pasteName = pasteName;
    this.syntaxHighlighting = syntaxHighlighting;
  }

  public String getPasteCode() {
    return pasteCode;
  }

  public String getPasteExpiration() {
    return pasteExpiration;
  }

  public String getPasteName() {
    return pasteName;
  }

  public String getSyntaxHighlighting() {
    return syntaxHighlighting;
  }
}
