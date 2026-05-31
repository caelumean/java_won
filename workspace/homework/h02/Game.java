package homework.h02;

import java.util.Scanner;

public class Game
{
    // 플레이어 일반 데미지
    static int getPlayerDamage()
    {
        return (int)(Math.random() * 6) + 5;
    }

    // 크리티컬
    static int playerCriticalAttack(int damage, double criticalMultiple, String enemyName, int enemyCurrentHp)
    {

        damage = (int)(damage * criticalMultiple);
        System.out.println("!!!!플레이어 크리티컬!!!!");
        enemyCurrentHp -= damage;
        System.out.println(enemyName + "에게 " + damage + "의 데미지를 주었습니다.");

        return enemyCurrentHp;
    }
    // 플레이어 일반 공격
    static int playerAttack(String playerName, String enemyName, int enemyCurrentHp)
    {
        int damage = getPlayerDamage();
        enemyCurrentHp -= damage;

        System.out.println(playerName + " 일반 공격!");
        System.out.println(enemyName + "에게 " + damage + "의 데미지를 주었습니다.");

        return  enemyCurrentHp;

    }
    static  int playerHill(String playerName, int playerCurrentHp,int Hp)
    {
        int hill = (int)(Math.random() * 11) + 10;
        playerCurrentHp += hill;

        // 힐했을때 최대 Hp보다 크지 못하게 막아주기
        if(playerCurrentHp > Hp)
        {
            playerCurrentHp = Hp;
        }

        System.out.println("체력 " + hill +"회복!!");
        System.out.println( playerName + "HP: " + playerCurrentHp + "/" + Hp);

        return playerCurrentHp;
    }

    static int playerUltimayeSkillUse(String enemyName, int enemyCurrentHp)
    {
        int playerDamage = getPlayerDamage();
        int ultimateDamage = playerDamage * 6;

        System.out.println("!!!필살기 사용!!!");
        System.out.println(enemyName + "에게 "+ ultimateDamage +"의 피해를 주었다!");
        enemyCurrentHp -= ultimateDamage;

        return enemyCurrentHp;

    }
    static int playerUltimateSkillHp(int playerCurrentHp, int Hp)
    {
        // 플레이어 체력 감소
        playerCurrentHp -= (int)(Hp * 0.1);

        return playerCurrentHp;
    }
    // 몬스터 종류
    static String getEnemyName(int enemy)
    {
        String enemyName = " ";
        if(enemy == 0)
        {
            return enemyName = "병사";
        }
        else if (enemy == 1)
        {
            return enemyName = "가고일";
        }
        else
        {
            return enemyName = "골렘";
        }
    }

    // 몬스터스킬이름
    static String getEnemySkillName(int enemy)
    {
        String enemySkillName = " ";

        if(enemy == 0)
        {
            return enemySkillName = "검 휘두르기";
        }
        else if (enemy == 1)
        {
            return enemySkillName = "물어찢기";
        }
        else
        {
            return enemySkillName = "돌주먹";
        }
    }

    // 몬스터 체력
    static int getEnemyHp(int enemy)
    {
        int enemyHp = 0;

        if(enemy == 0)
        {
            enemyHp = (int)(Math.random() * 11) + 10; // 10 ~ 20
            return enemyHp;
        }
        else if (enemy == 1)
        {
            enemyHp = (int)(Math.random() * 11) + 30; // 30 ~ 40
            return enemyHp;
        }
        else
        {
            enemyHp = (int)(Math.random() * 11) + 60; // 60 ~ 70
            return enemyHp;
        }
    }
    // 몬스터 데미지
    static int getEnemyDamage(int enemy)
    {
        int enemyDamage = 0;
        if(enemy == 0)
        {
            enemyDamage = 5;
            return enemyDamage;
        }
        else if (enemy == 1)
        {
            enemyDamage = 15;
            return enemyDamage;
        }
        else
        {
            enemyDamage = 30;
            return enemyDamage;
        }
    }
    // 몬스터 크리티컬 확률
    static int getEnemyCriticalChance(int enemy)
    {
        int enemyCriticalChance = 0;
        if(enemy == 0)
        {
            enemyCriticalChance = 30;
            return enemyCriticalChance;
        }
        else if (enemy == 1)
        {
            enemyCriticalChance = 20;
            return enemyCriticalChance;
        }
        else
        {
            enemyCriticalChance = 10;
            return enemyCriticalChance;
        }
    }
    // 몬스터 크리티컬 데미지
    static int getEnemyCriticalDamage( int enemyDamage, double enemyCriticalMultiple)
    {
        int enemyCriticalDamage = 0;
        enemyCriticalDamage =  (int)(enemyDamage * enemyCriticalMultiple);

        return enemyCriticalDamage;
    }
    // 몬스터 스킬 확률
    static int getEnemySkillChance(int enemy)
    {
        int enemySkillChance = 0;

        if(enemy == 0)
        {
            enemySkillChance = 30;
            return enemySkillChance;
        }
        else if (enemy == 1)
        {
            enemySkillChance = 30;
            return enemySkillChance;
        }
        else
        {
            enemySkillChance = 20;
            return enemySkillChance;
        }
    }
    // 몬스터 스킬 배수
    static double getEnemySkillMultiplier(int enemy)
    {
        double enemySkillMultiplier = 0;

        if(enemy == 0)
        {
            enemySkillMultiplier = 1.2;
            return enemySkillMultiplier;
        }
        else if (enemy == 1)
        {
            enemySkillMultiplier = 1.5;
            return enemySkillMultiplier;
        }
        else
        {
            enemySkillMultiplier = 1.8;
            return enemySkillMultiplier;
        }
    }
    // 몬스터 스킬 데미지
    static int getEnemySkillDamage(int enemyDamage, double enemySkillMultiplier)
    {
        int enemySkillDamage = 0;
        enemySkillDamage = (int)(enemyDamage * enemySkillMultiplier);
        return enemySkillDamage;
    }
    // 몬스터 스킬 사용
    static int enemySkillUse(String enemyName, String enemySkillName, int enemySkillDamage, String playerName, int playerCurrentHp)
    {
        System.out.println("!"+enemyName + " " + enemySkillName +" 스킬 사용!");
        playerCurrentHp -= enemySkillDamage;
        System.out.println(playerName + "가(이) "+enemySkillDamage + "피해를 입었습니다.");

        return playerCurrentHp;
    }
    // 몬스터 크리티컬
    static int enemyCriticalUse(String enemyName, int enemyCriticalDamage, String playerName, int playerCurrentHp)
    {
        System.out.println("!!!!"+enemyName+" 크리티컬!!!!");
        playerCurrentHp -= enemyCriticalDamage;
        System.out.println(playerName + "가(이) "+enemyCriticalDamage + " 피해를 입었습니다.");

        return playerCurrentHp;
    }
    // 몬스터 일반공격
    static int enemyAttack(String enemyName, int enemytDamage,String playerName, int playerCurrentHp)
    {
        System.out.println(enemyName + " 일반 공격!");
        playerCurrentHp -= enemytDamage;
        System.out.println(playerName + "가(이) "+ enemytDamage + " 피해를 입었습니다.");

        return playerCurrentHp;
    }
    // 몬스터 죽음
    static void printEnemyDead(String enemyName,int enemyHp, int enemyCurrentHp)
    {
        enemyCurrentHp = 0;
        System.out.println( enemyName + "HP: " + enemyCurrentHp + "/" + enemyHp);
        System.out.println(enemyName + " 처치!");
    }

    // 게임시작시
    static int printGameStart(String playerName, String enemyName, int enemyCurrentHp,int enemyHp)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("----------------" +playerName + "의 모험----------------");

        System.out.println(enemyName);
        System.out.println("HP: " + enemyCurrentHp + "/" + enemyHp);
        System.out.println("1) 싸운다 2) 도망간다 3) HP 회복 4) 필살기");

        int choice =  sc.nextInt();

        return choice;
    }
    // 플레이어 Hp와 몬스터Hp 출력
    static void printPlayerHpEnemyHp(String playerName, int playerCurrentHp,int playerHp, String enemyName, int enemyCurrentHp, int enemyHp)
    {
        System.out.println( enemyName + "HP: " + enemyCurrentHp + "/" + enemyHp);
        System.out.println( playerName + "HP: " + playerCurrentHp + "/" + playerHp);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("***멋쟁이 전사처럼***");
        System.out.println("캐릭터 이름을 지어주세요.");

        // 플레이어 관련
        String name = sc.next();
        int Hp = 100;       // 최대Hp
        int currentHp = Hp; // 현재Hp
        int damage = 0;     // 데미지

        // 크리티컬
        int criticalChance = 20;          // 20퍼
        double criticalMultiple = 2.0;    // 2배

        int ultimateSkill = 1; // 필살기 기술 수량


        // 몬스터 관련
        String enemyName = "";
        String enemySkillName = "";
        int enemy = 0;
        int enemyHp = 0;        // 몬스터 최대HP
        int enemyCurrentHp = 0; // 몬스터 현재HP
        int enemyDamage = 0;    // 몬스터 데미지

        int enemyCriticalChance = 0;
        int enemyCriticalDamage = 0;

        int enemySkillChance = 0;
        int enemySkillDamage = 0;
        double enemySkillMultiplier = 0;

        boolean isRunning = true;


        System.out.println(name + " 모험가님 어서오세요");
        System.out.println("모험을 시작합니다");

        // 몬스터 생성
        // 몬스터 종류 만들기
        // 3종류 - 병사/ 가고일/ 골렘
        enemy = (int)(Math.random() * 3);

        enemyName = getEnemyName(enemy);
        enemySkillName = getEnemySkillName(enemy);
        enemyHp = getEnemyHp(enemy);
        enemyCurrentHp = enemyHp;
        enemyDamage = getEnemyDamage(enemy);
        enemyCriticalChance = getEnemyCriticalChance(enemy);
        enemySkillMultiplier = getEnemySkillMultiplier(enemy);
        enemyCriticalDamage = getEnemyCriticalDamage(enemyDamage,enemySkillMultiplier);
        enemySkillChance = getEnemySkillChance(enemy);
        enemySkillDamage = getEnemySkillDamage(enemyDamage,enemySkillMultiplier);

        while(isRunning)
        {
            int action = printGameStart(name, enemyName, enemyCurrentHp, enemyHp);

            switch(action)
            {
                // 일반 공격
                // 크리티컬 확률
                case 1 -> {

                    int criticalProb = (int)(Math.random() * 100);

                    System.out.println(enemyName + "와(과) 싸웁니다.");
                    // 플레이어 데미지
                    damage = getPlayerDamage();  // 5 ~ 10
                    // 플레이어
                    // 크리티컬일 경우
                    if(criticalProb < criticalChance)
                    {
                        enemyCurrentHp = playerCriticalAttack(damage,criticalMultiple,enemyName,enemyCurrentHp);
                    }
                    else
                    {
                        enemyCurrentHp = playerAttack(name,enemyName,enemyCurrentHp);
                    }
                    // 몬스터 체력이 0보다 작을 경우 -로 표기 안하고 0으로 고정
                    // 몬스터가 죽었을 때 공격하는 거 막기
                    if(enemyCurrentHp <= 0)
                    {
                        printEnemyDead(enemyName,enemyHp, enemyCurrentHp);

                        break;
                    }

                    // 몬스터 데미지 / 스킬 /크리티컬
                    int enemyCriticalProb = (int)(Math.random() * 100);
                    int enemySkillProb = (int)(Math.random() * 100);

                    // 스킬
                    if(enemySkillProb < enemySkillChance)
                    {
                        currentHp = enemySkillUse(enemyName,enemySkillName,enemySkillDamage,name,currentHp);
                    }
                    //크리티컬
                    else if(enemyCriticalProb < enemyCriticalChance)
                    {
                        currentHp = enemyCriticalUse(enemyName, enemyCriticalDamage, name, currentHp);
                    }
                    // 일반 공격
                    else
                    {
                        currentHp = enemyAttack(enemyName, enemyDamage, name, currentHp);
                    }

                    // 플레이어 체력이 0일 경우 -로 표기 안하고 0으로 고정
                    if(currentHp <= 0)
                    {
                        currentHp = 0;
                    }

                    printPlayerHpEnemyHp(name, currentHp, Hp, enemyName, enemyCurrentHp, enemyHp);

                }
                case 2 -> {
                    System.out.println("무사히 도망쳤습니다.");
                    isRunning = false;
                }
                // HP 회복 : 10 ~ 20 사이
                case 3 -> {
                  currentHp = playerHill(name, currentHp, Hp);
                }
                // 필살기 바꿔보기
                // 플레이어의 최대 체력 10퍼센트 감소 시키기
                // 사용 횟수 1
                // 데미지 6배
                case 4 -> {
                    if(ultimateSkill > 0)
                    {

                        enemyCurrentHp = playerUltimayeSkillUse(enemyName,enemyCurrentHp);
                        // Skill 횟수 감소
                        ultimateSkill--;
                        currentHp = playerUltimateSkillHp(currentHp, Hp);

                        // enemy 체력이 0일 경우 -로 표기안하고 0으로 표기
                        if(enemyCurrentHp < 0)
                        {
                            enemyCurrentHp = 0;
                        }

                        printPlayerHpEnemyHp(name, currentHp, Hp, enemyName, enemyCurrentHp, enemyHp);
                    }
                    else
                    {
                        System.out.println("사용할 수 있는 필살기가 없습니다.");
                    }
                }
            }
            // 플레이어HP / 몬스터HP
            if(currentHp <= 0 || enemyCurrentHp <= 0)
            {
                break;
            }
        }

        if(currentHp <= 0)
        {
            System.out.println("당신은 사망했습니다. - The end -");
        }
        else if(enemyCurrentHp <= 0)
        {
            System.out.println("전투에 승리했습니다. - The end -");
        }
    }
}