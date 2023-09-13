import java.util.Arrays;
import java.util.Date;

/**
 * BlockChain을 구성하는 Block 을 생성한다,
 * Block은 BlockChain 내에서 고유한 Hash(Digital Signature)값을 가지고 있다.
 * Block 내에는 이전 Block의 Hash 값과 데이터들이 포함되어 있다.
 */
public class Block {

    private String hash;
    private String previousHash;

    private String data;
    private long timeStamp;

    private int nonce;

    private Block() {

    }

    /**
     * Block Constructor
     *생성자 내에 해당 메소드 호출 추가
     * @param data
     * @param previousHash
     */
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;

        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    /**
     * Hash값 계산하기!
     *BcUtils 를 이용하여 Block 안 Hash값을 만드는 로직을 추가
     * @return
     */
    public String calculateHash() {
        return BcUtils.generateHash(previousHash, Long.toString(timeStamp), Integer.toString(nonce), data);
    }

    /**
     * Mining
     */
    public void mineBlock() {
        char[] targetChar = new char[BlockChain.DIFFICULTY];
        Arrays.fill(targetChar, '0');
        String target = String.valueOf(targetChar);

        while (hash.substring(0, BlockChain.DIFFICULTY).equals(target) == false) {
            nonce++;
            hash = calculateHash();
        }

        System.out.println("Block Mined!!! : " + hash);
    }

    /**
     * get previousHash
     *
     * @return
     */
    public String getPreviousHash() {
        return previousHash;
    }

    /**
     * get Hash
     *  - digital signature
     *
     * @return
     */
    public String getHash() {
        return hash;
    }

    /**
     * get TimeStamp
     *
     * @return
     */
    public long getTimeStamp() {
        return timeStamp;
    }

    /**
     * get Data
     *
     * @return
     */
    public String getData() {
        return data;
    }

    /**
     * get nonce
     *
     * @return
     */
    public int getNonce() {
        return nonce;
    }
}
