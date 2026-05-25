package homework.h01;

import java.util.Scanner;

public class Game
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("***멋쟁이 전사처럼***");
        System.out.println("캐릭터 이름을 지어주세요.");

        // 플레이어 관련
        String name = s.next();
        int Hp = 100;       // 최대Hp
        int currentHp = Hp; // 현재Hp
        int damage = 0;     // 데미지

        // 크리티컬
        int criticalChance = 50;          // 20퍼
        double criticalMultiple = 2.0;    // 2배

        int ultimateSkill = 1; // 필살기 기술 수량


        // 몬스터 관련
        int enemy = 0;
        String enemyName = "";
        String enemySkillName = "";
        int enemyHp = 0;        // 몬스터 HP
        int enemyCurrentHp = 0; // 몬스터 현재HP
        int enemyDamage = 0;    // 몬스터 피해량

        int enemyCriticalChance = 0;

        int enemySkillChance = 0;
        double enemySkillMultiplier = 0;
        int enemySkillDamage = 0;

        System.out.println(name + " 모험가님 어서오세요");
        System.out.println("모험을 시작합니다");

        // 몬스터 생성
        // 몬스터 종류 만들기
        // 3종류 - 병사/ 가고일/ 골렘
        enemy = (int)(Math.random() * 3);
        switch (enemy)
        {
            case 0 -> {
                enemyName = "병사";
                enemySkillName = "칼휘두르기";
                enemyHp = (int)(Math.random() * 11) + 10; // 10 ~ 20
                // 최대 체력을 현재 체력에 넣기
                enemyCurrentHp = enemyHp;
                enemyDamage = 5;

                // 크리티컬
                enemyCriticalChance = 20;

                // 스킬
                enemySkillChance = 30;
                enemySkillMultiplier = 1.2;
                enemySkillDamage = (int)(enemyDamage * enemySkillMultiplier);

            }
            case 1 -> {
                enemyName = "가고일";
                enemySkillName = "꼬리휘두르기";
                enemyHp = (int)(Math.random() * 11) + 30; // 30 ~ 40
                enemyCurrentHp = enemyHp;
                enemyDamage = 15;

                // 크리티컬
                enemyCriticalChance = 20;

                // 스킬
                enemySkillChance = 30;
                enemySkillMultiplier = 1.5;
                enemySkillDamage = (int)(enemyDamage * enemySkillMultiplier);
            }
            case 2 -> {
                enemyName = "골렘";
                enemySkillName = "돌주먹";
                enemyHp = (int)(Math.random() * 11) + 60; // 60 ~ 70
                enemyCurrentHp = enemyHp;
                enemyDamage = 30;

                // 크리티컬
                enemyCriticalChance = 10;

                // 스킬
                enemySkillChance = 20;
                enemySkillMultiplier = 1.8;
                enemySkillDamage = (int)(enemyDamage * enemySkillMultiplier);
            }
        }

        while(true)
        {
            System.out.println("----------------" +name + "의 모험----------------");

            System.out.println( enemyName + "HP: " + enemyCurrentHp + "/" + enemyHp);
            System.out.println("1) 싸운다 2) 도망간다 3) HP 회복 4) 필살기");
            int action = s.nextInt();

            switch(action){
                // 일반 공격
                // 크리티컬 확률
                case 1 -> {

                    int criticalProb = (int)(Math.random() * 100);

                    System.out.println(enemyName + "와(과) 싸웁니다.");
                    // 플레이어 데미지
                    damage = (int)(Math.random() * 6) + 5;  // 5 ~ 10
                    // 플레이어
                    // 크리티컬일 경우
                    if(criticalProb < criticalChance)
                    {
                        damage = (int)(damage * criticalMultiple);
                        System.out.println("!!!!플레이어 크리티컬!!!!");
                        enemyCurrentHp -= damage;
                        System.out.println(enemyName + "에게 " + damage + "의 데미지를 주었습니다.");

                    }
                    else
                    {
                        System.out.println(name + " 일반 공격!");
                        enemyCurrentHp -= damage;
                        System.out.println(enemyName + "에게 " + damage + "의 데미지를 주었습니다.");

                    }
                    // 몬스터 체력이 0보다 작을 경우 -로 표기 안하고 0으로 고정
                    // 몬스터가 죽었을 때 공격하는 거 막기
                    if(enemyCurrentHp <= 0)
                    {
                        enemyCurrentHp = 0;
                        System.out.println( enemyName + "HP: " + enemyCurrentHp + "/" + enemyHp);
                        System.out.println(enemyName + " 처치!");

                        break;
                    }

                    // 몬스터 데미지 / 스킬 /크리티컬
                    int enemyCurrentDamage = enemyDamage;
                    double enemyCriticalMultiple = 2.0;
                    int enemyCriticalProb = (int)(Math.random() * 100);
                    int enemySkillProb = (int)(Math.random() * 100);

                    // 스킬
                    if(enemySkillProb < enemySkillChance)
                    {
                        enemyCurrentDamage = (int)(enemyCurrentDamage * enemySkillMultiplier);
                        System.out.println("!"+enemyName + " " + enemySkillName +" 스킬 사용!");
                        currentHp -= enemyCurrentDamage;
                        System.out.println(name + "가(이) "+enemyCurrentDamage + "피해를 입었습니다.");
                        //System.out.println("몬스터 데미지: " +enemyDamage + "/" + enemyCurrentDamage);

                    }
                    //크리티컬
                    else if(enemyCriticalProb < enemyCriticalChance)
                    {
                        enemyCurrentDamage = (int)(enemyCurrentDamage * enemyCriticalMultiple);
                        System.out.println("!!!!"+enemyName+" 크리티컬!!!!");
                        currentHp -= enemyCurrentDamage;
                        System.out.println(name + "가(이) "+enemyCurrentDamage + " 피해를 입었습니다.");
                        //System.out.println("몬스터 데미지: " +enemyDamage + "/" + enemyCurrentDamage);


                    }
                    // 일반 공격
                    else
                    {
                        System.out.println(enemyName + " 일반 공격!");
                        currentHp -= enemyDamage;
                        System.out.println(name + "가(이) "+enemyCurrentDamage + " 피해를 입었습니다.");

                    }

                    // 플레이어 체력이 0일 경우 -로 표기 안하고 0으로 고정
                    if(currentHp <= 0)
                    {
                        currentHp = 0;
                        System.out.println( name + "HP: " + currentHp + "/" + Hp);
                    }

                    System.out.println( enemyName + "HP: " + enemyCurrentHp + "/" + enemyHp);
                    System.out.println( name + "HP: " + currentHp + "/" + Hp);

                }
                case 2 -> {
                    System.out.println("무사히 도망쳤습니다.");
                    System.out.println( name + "HP: " + currentHp + "/" + Hp);
                }
                // HP 회복 : 10 ~ 20 사이
                case 3 -> {
                    int hill = (int)(Math.random() * 11) + 10;
                    currentHp += hill;

                    // 힐했을때 최대 Hp보다 크지 못하게 막아주기
                    if(currentHp > Hp)
                    {
                        currentHp = Hp;
                    }

                    System.out.println("체력 " + hill +"회복!!");
                    System.out.println( name + "HP: " + currentHp + "/" + Hp);
                }
                // 필살기 바꿔보기
                // 플레이어의 최대 체력 10퍼센트 감소 시키기
                // 사용 횟수 1
                // 데미지 6배
                case 4 -> {
                    if(ultimateSkill > 0)
                    {
                        damage = (int)(Math.random() * 6) + 5;  // 5 ~ 10
                        int ultimateDamage = damage * 6;

                        System.out.println("!!!필살기 사용!!!");
                        System.out.println(enemyName + "에게 "+ ultimateDamage +"의 피해를 주었다!");
                        enemyCurrentHp -= ultimateDamage;
                        // 플레이어 체력 감소
                        currentHp -= (int)(Hp * 0.1);
                        // Skill 횟수 감소
                        ultimateSkill--;

                        // enemy 체력이 0일 경우 -로 표기안하고 0으로 표기
                        if(enemyCurrentHp < 0)
                        {
                            enemyCurrentHp = 0;
                        }

                        System.out.println( enemyName + "HP: " + enemyCurrentHp + "/" + enemyHp);
                        System.out.println( name + "HP: " + currentHp + "/" + Hp);

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